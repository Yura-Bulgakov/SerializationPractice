package org.example.mapping;

import org.example.client.ClientInfo;
import org.example.person.PersonInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ClientToPersonMapper implements TypeMapper<ClientInfo, PersonInfo> {
    @Mapping(source = "clientFindInfo.dul.lastName", target = "findPersonInfo.personName.lastName")
    @Mapping(source = "clientFindInfo.dul.firstName", target = "findPersonInfo.personName.firstName")
    @Mapping(source = "clientFindInfo.dul.secondName", target = "findPersonInfo.personName.middleName")
    @Mapping(source = "clientFindInfo.dul.documentType", target = "findPersonInfo.identityCard.idType")
    @Mapping(source = "clientFindInfo.dul.series", target = "findPersonInfo.identityCard.idSeries")
    @Mapping(source = "clientFindInfo.dul.number", target = "findPersonInfo.identityCard.idNum")
    @Override
    public abstract PersonInfo map(ClientInfo clientInfo);
}
