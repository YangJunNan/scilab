/*
 *  Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
 *  Copyright (C) 2014-2014 - Scilab Enterprises - Clement DAVID
 *  Copyright (C) 2017 - ESI Group - Clement DAVID
 *
 * Copyright (C) 2012 - 2016 - Scilab Enterprises
 *
 * This file is hereby licensed under the terms of the GNU GPL v2.0,
 * pursuant to article 5.3.4 of the CeCILL v.2.1.
 * This file was originally licensed under the terms of the CeCILL v2.1,
 * and continues to be available under such terms.
 * For more information, see the COPYING file which you should have received
 * along with this program.
 *
 */

#ifndef ADAPTERS_UTILITIES_HXX_
#define ADAPTERS_UTILITIES_HXX_

#include <string>
#include <unordered_map>
#include <vector>

#include <double.hxx>

typedef std::vector<unsigned int> link_indices_t;
template<typename K, typename T>
using partials_map_t = std::unordered_map<K, T>;

/*
 * Partial information used on LinkAdapter
 */

enum startOrEnd
{
    Start = 0,
    End = 1
};

struct link_t
{
    int block;
    int port;
    enum startOrEnd kind;
};

inline std::string to_string(const link_t& l)
{
    return "[ " + std::to_string(l.block) + ", " + std::to_string(l.port) + ", " + std::to_string(l.kind) + " ]";
};

// partial-link information
struct partial_link_t
{
    link_t from;
    link_t to;
};

inline std::string to_string(const partial_link_t& l)
{
    return "{ \"from\": " + to_string(l.from) + ", \"to\": " + to_string(l.to) + " }";
};

typedef partials_map_t<ScicosID, partial_link_t> partials_links_t;

inline std::string to_string(const partials_links_t& links)
{
    if (links.size() == 0)
    {
        return "{}";
    }

    std::string inner;
    for (const auto& e : links)
    {
        inner += "\"" + std::to_string(e.first) + "\": " + to_string(e.second) + ", ";
    }
    inner = inner.substr(0, inner.size() - 2);

    return "{ " + inner + " }";
};

/*
 * Partial information used on GraphicsAdapter
 */

class partial_port_t
{
  public:
    types::Double* pin;
    types::Double* pout;
    types::Double* pein;
    types::Double* peout;

    partial_port_t(types::Double* _pin, types::Double* _pout, types::Double* _pein, types::Double* _peout) : 
        pin(_pin), pout(_pout), pein(_pein), peout(_peout)
    {
        pin->IncreaseRef();
        pout->IncreaseRef();
        pein->IncreaseRef();
        peout->IncreaseRef();
    };

    partial_port_t() : partial_port_t(types::Double::Empty(), types::Double::Empty(), types::Double::Empty(), types::Double::Empty()) {};
    partial_port_t(const partial_port_t& other) : partial_port_t(other.pin, other.pout, other.pein, other.peout) {};
    
    ~partial_port_t()
    {
        pin->DecreaseRef();
        pin->killMe();
        pout->DecreaseRef();
		pout->killMe();
        pein->DecreaseRef();
        pein->killMe();
        peout->DecreaseRef();
        peout->killMe();
    };

    partial_port_t(const partial_port_t&& other) noexcept
    {
        pin = other.pin;
        pin->IncreaseRef();
        pout = other.pout;
        pout->IncreaseRef();
        pein = other.pein;
        pein->IncreaseRef();
        peout = other.peout;
        peout->IncreaseRef();
    };

    partial_port_t& operator=(const partial_port_t& other)
    {
        pin->DecreaseRef();
        pin->killMe();
        pin = other.pin;
        pin->IncreaseRef();

        pout->DecreaseRef();
        pout->killMe();
        pout = other.pout;
        pout->IncreaseRef();
                
        pein->DecreaseRef();
		pein->killMe();
        pein = other.pein;
        pein->IncreaseRef();
                
        peout->DecreaseRef();
		peout->killMe();
        peout = other.peout;
        peout->IncreaseRef();
		
		return *this;
	};

    partial_port_t& operator=(partial_port_t&& other) noexcept
    {
        pin->DecreaseRef();
        pin->killMe();
        pin = other.pin;
        pin->IncreaseRef();

        pout->DecreaseRef();
        pout->killMe();
        pout = other.pout;
        pout->IncreaseRef();

        pein->DecreaseRef();
        pein->killMe();
        pein = other.pein;
        pein->IncreaseRef();

        peout->DecreaseRef();
        peout->killMe();
        peout = other.peout;
        peout->IncreaseRef();
		
        return *this;
	};
}
;

typedef partials_map_t<ScicosID, partial_port_t> partials_ports_t;

inline std::string to_string(const std::vector<int>& v)
{
    if (v.size() == 0)
    {
        return "[]";
    }

    std::string inner;
    for (int index : v)
    {
        inner += std::to_string(index) + ", ";
    }
    inner = inner.substr(0, inner.size() - 2);

    return "[ " + inner + " ]";
};

inline std::string to_string(const types::Double* value)
{
    int len = value->getSize();
    double* data = value->get();

    std::string str;

    str += "[";
    if (len > 0)
        str += std::to_string((int)*data);
    for (int i = 1; i < len; ++i)
    {
        str += ", ";
        str += std::to_string((int)data[i]);
    }
    str += "]";

    return str;
};

inline std::string to_string(const partial_port_t& ports)
{
    return "{ \"pin\": " + to_string(ports.pin) +
           ", \"pout\": " + to_string(ports.pout) +
           ", \"pein\": " + to_string(ports.pein) +
           ", \"peout\": " + to_string(ports.peout) +
           " }";
};

inline std::string to_string(const partials_ports_t& ports)
{
    if (ports.size() == 0)
    {
        return "{}";
    }

    std::string inner;
    for (const auto& e : ports)
    {
        inner += "\"" + std::to_string(e.first) + "\": " + to_string(e.second) + ", ";
    }
    inner = inner.substr(0, inner.size() - 2);

    return "{ " + inner + " }";
}

#endif /* ADAPTERS_UTILITIES_HXX_ */
