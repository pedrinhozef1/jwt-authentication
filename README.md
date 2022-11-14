# Jwt authentication project

> ## Requirements:
> #### - Docker
> #### - Envfiles plugin in IDE

> ## How to run?
>  #### - Execute docker-compose.yml
>  #### - Add .env file and put the values in the variables
>  #### - Create rsa private/public key to generate jwt token
 
>  ## How to create rsa private/public key
> > ### Execute in terminal to generate Private key:
> > ####  openssl genpkey -out private.pem -algorithm RSA -pkeyopt rsa_keygen_bits:2048
>
> > ### Execute in terminal to generate Public key:
> > #### openssl rsa -in private.pem -outform PEM -pubout -out public.pem

> ### .env template:
> > PORT= < only if you want a port other than 8080 >\
> > DB_HOST=localhost\
> > DB_PORT=5432\
> > DB_NAME=authentication\
> > DB_SCHEMA=authentication\
> > DB_USER=admin\
> > DB_PASSWORD=admin\
> > SECRETKEY= < put any value to use encrypt and decrypt >\
> > SALT= < put any value to use encrypt and decrypt >\
> > ISSUER= < put issuer name for to sign jwt >\
> > PUBLICKEY= < create rsa public key and paste here >\
> > PRIVATEKEY= < create rsa private key and paste here >