//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------


function demo_single_pendulum()

    //Simple pendulum: define the potential and the constraints:
    function [Vd,Dd,Fd]=single_pend(t,x,u,mass,g)
        // derivative of the potential
        Vd =  [0 mass*g];
        // derivative of the Rayleigh function (Viscous forces)
        Dd = 0*u.';
        // half derivative of the constraints function x(1)^2+x(2)^2=l
        Fd = x.';
    endfunction

    //display callback
    function term=cbFn(t,y,yp,flag,stats)
        term=%f;
        if flag=="init"
            clf
            demo_viewCode("demo_single_pendulum.sce")
            gcf().color_map=parulacolormap(128);
            colorbar(-50,10)
            h=plot([0 y(1)],[0 y(2)],"-o","thickness",10);
            h.tag="pendulum";
            xstring(-0.5,0.5,"color shows Lagrange multiplier")
            gce().alignment="center";
            gce().font_size=2
            isoview on
            gca().data_bounds=[-1.1 1.1 -1.1 1.1]
            title(msprintf("t=%4.1f",t))
        else
            try
                h=findobj("tag","pendulum");
                if is_handle_valid(h)
                    realtime(t)
                    x=y(1:2*nb);
                    lambda=y($);
                    h.data=[0 0;x'];
                    h.foreground=min(128,1+floor((lambda+50)/(60)*128));
                    gca().title.text=msprintf("t=%4.1f",t);
                else
                term=%t;
                end
            catch
                term=%t
            end
        end
    end
    exec(fullfile(get_absolute_file_path(),"lagrangian_DAE.sce"),-1)
    
    mass=1;
    th=%pi/2.1
    x0=[cos(th);sin(th)];
    u0=[0;0];
    
    realtimeinit(1)
    realtime(0)

    compute(list(single_pend,9.81),[0 60],x0,u0,mass,rtol=1e-6,atol=1e-9,callback=cbFn)

endfunction
demo_single_pendulum()

clear demo_single_pendulum
