Build step: 

Use command "mvn clean install"  to generate build of the application

https://secure-psuedo-queue.herokuapp.com/addAccount

Method : POST

Request Body: {
    "accountNmbr":"12345",
    "type":"Credit",
    "amount":"100000",
    "currency":"INR",
    "accountFrom":"54321"
}


Internal API

Endpoint: https://pseudo-queue.herokuapp.com/pseudo-queue/addAccount
Method: POST,
Request Body: encode base 64 this JSON 

{
    "accountNmbr":"12345",
    "type":"Credit",
    "amount":"100000",
    "currency":"INR",
    "accountFrom":"54321"
}

https://pseudo-queue.herokuapp.com/pseudo-queue/getAccountInfo

Method : GET
fetches all the data