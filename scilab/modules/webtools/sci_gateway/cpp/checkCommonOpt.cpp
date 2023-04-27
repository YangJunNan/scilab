/*
* Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
* Copyright (C) 2017 - ESI-Group - Cedric DELAMARRE
*
* This file is hereby licensed under the terms of the GNU GPL v2.0,
* pursuant to article 5.3.4 of the CeCILL v.2.1.
* This file was originally licensed under the terms of the CeCILL v2.1,
* and continues to be available under such terms.
* For more information, see the COPYING file which you should have received
* along with this program.
*
*/
/*--------------------------------------------------------------------------*/

#include <curl/curl.h>
#include "webtools_gw.hxx"
#include "function.hxx"
#include "string.hxx"
#include "sciCurl.hxx"

extern "C"
{
#include "localization.h"
#include "Scierror.h"
#include "sciprint.h"
#include "sci_malloc.h"
}

static int debug_callback(CURL *handle,
                   curl_infotype type,
                   char *data,
                   size_t size,
                   void *clientp);

/*--------------------------------------------------------------------------*/
int checkCommonOpt(void* _curl, types::optional_list &opt, const char* fname)
{
    CURL* curl = (CURL*)_curl;

    // get optional argument if necessary
    for (const auto& o : opt)
    {
        if (o.first == L"cert")
        {
            if(o.second->isString() == false || o.second->getAs<types::String>()->isScalar() == false)
            {
                Scierror(999, _("%s: Wrong type for input argument #%s: A scalar string expected.\n"), fname, o.first.data());
                return 1;
            }

            wchar_t* pCert = o.second->getAs<types::String>()->get(0);
            if(wcscmp(pCert, L"none") == 0)
            {
                curl_easy_setopt(curl, CURLOPT_SSL_VERIFYPEER, false);
                return 0;
            }
            // TODO management of cert file
            // else if cert is file

            Scierror(999, _("%s: Wrong value for input argument #%s: 'none' expected.\n"), fname, o.first.data());
            return 1;
        }
        else if(o.first == L"follow")
        {
            if(o.second->isBool() == false || o.second->getAs<types::Bool>()->isScalar() == false)
            {
                Scierror(999, _("%s: Wrong type for input argument #%s: A scalar boolean expected.\n"), fname, o.first.data());
                return 1;
            }

            if(o.second->getAs<types::Bool>()->get(0) == 1)
            {
                curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1);
            }
        }
        else if(o.first == L"auth")
        {
            if(o.second->isString() == false || o.second->getAs<types::String>()->isScalar() == false)
            {
                Scierror(999, _("%s: Wrong type for input argument #%s: A scalar string expected.\n"), fname, o.first.data());
                return 1;
            }

            char* pAuth = wide_string_to_UTF8(o.second->getAs<types::String>()->get(0));
            curl_easy_setopt(curl, CURLOPT_HTTPAUTH, CURLAUTH_ANY);
            curl_easy_setopt(curl, CURLOPT_USERPWD, pAuth);
            FREE(pAuth);
        }
        else if(o.first == L"verbose")
        {
            if(o.second->isBool() == false || o.second->getAs<types::Bool>()->isScalar() == false)
            {
                Scierror(999, _("%s: Wrong type for input argument #%s: A scalar boolean expected.\n"), fname, o.first.data());
                return 1;
            }

            if(o.second->getAs<types::Bool>()->get(0) == 1)
            {
                curl_easy_setopt(curl, CURLOPT_VERBOSE, 1L);

                curl_easy_setopt(curl, CURLOPT_DEBUGDATA, fname); 
                curl_easy_setopt(curl, CURLOPT_DEBUGFUNCTION, debug_callback); 
            }
        }
    }

    return 0;
}

static int debug_callback(CURL* handle, curl_infotype type, char* data, size_t size, void* clientp)
{
    const char* fname = (char*) clientp;

    switch(type)
    {
        case CURLINFO_TEXT:
            //sciprint("%s: %.*s", fname, size, data);
            break;
        case CURLINFO_HEADER_IN:
            sciprint("%s: header in: %.*s", fname, size, data);
            break;
        case CURLINFO_HEADER_OUT:
            sciprint("%s: header out: %.*s", fname, size, data);
            break;
        case CURLINFO_DATA_IN:
            sciprint("%s: data in: %d bytes\n", fname, size);
            break;
        case CURLINFO_DATA_OUT:
            sciprint("%s: data out: %d bytes\n", fname, size);
            break;
        case CURLINFO_SSL_DATA_IN:
            sciprint("%s: SSL data in: %d bytes\n", fname, size);
            break;
        case CURLINFO_SSL_DATA_OUT:
            sciprint("%s: SSL data out: %d bytes\n", fname, size);
            break;
    }

    return 0;
}