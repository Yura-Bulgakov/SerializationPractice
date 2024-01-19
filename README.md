# Serialization Practice
### Задание

Написать программу, которая читает данные из файла ClientInfo.xml и записывает данные в файл PersonInfo.json

### ClientInfo.xml
```xml
<clientInfo>
  <clientFindInfo>
    <dul>
      <documentType>99</documentType>
      <firstName>firstName</firstName>
      <lastName>lastName</lastName>
      <secondName>secondName</secondName>
      <number>645354</number>
      <series>6200</series>
    </dul>
    <partyId>32</partyId>
  </clientFindInfo>
</clientInfo>
```
### PersonInfo.json
```json
{
  "PersonInfo": {
    "FindPersonInfo": {
      "PersonName": {
        "LastName": "lastName",
        "FirstName": "firstName", "MiddleName": "secondName"
      },
      "IdentityCard": {
        "IdType": 99,
        "IdSeries": 6200, "IdNum": 645354
      },
      "PartyID": 32 }
  }
}
```