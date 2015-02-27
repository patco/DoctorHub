package com.patco.doctorhub.shared.rest.api;

import java.util.List;


import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.patco.doctorhub.shared.dto.AccountsDto;

@Path(ApiPaths.ACCOUNTS)
@Produces(MediaType.APPLICATION_JSON)
public interface AccountsResource {
    @GET
    List<AccountsDto> getAccounts();
}
