# Project Management

This project handles two crucial entities for the application purpose, the Project Entity, and the Employee Entity. 
Thus, by maintaining the employees and projects and having a relationship between these two we have additional tables to help the purpose of perceiving the flow of the 
project and the involvement of the employees in projects.

## Getting Started

Home page

![screadme](https://user-images.githubusercontent.com/24781579/114738381-335ef780-9d48-11eb-838f-ad6ee4ae06f6.png)

Home page scrolled

![screadme](https://user-images.githubusercontent.com/24781579/114738687-7d47dd80-9d48-11eb-9cef-66abe816f1f0.png)

The Employee directory 

![screadme](https://user-images.githubusercontent.com/24781579/114739776-78cff480-9d49-11eb-9c7d-1eb7088e7ff9.png)

The Rrojects directory, and we try to add a new project...

![projects](https://user-images.githubusercontent.com/24781579/114740026-bdf42680-9d49-11eb-851e-ce182e1e662f.png)

We must sign in before we try to do any of the CRUD, so we logged in as a dummy user with USER_ROLE 

![projects](https://user-images.githubusercontent.com/24781579/114742785-5ab7c380-9d4c-11eb-8aa2-b79f13e5102f.png)

and it redirect us to error 403:forbidden. We must have a ADMIN_ROLE to use CRUD operations

![projects](https://user-images.githubusercontent.com/24781579/114740681-5c808780-9d4a-11eb-8d24-67f95841ec0d.png)

We logged out, and logged in with a user with ADMIN_ROLE and added a new project

![projects](https://user-images.githubusercontent.com/24781579/114743405-f3e6da00-9d4c-11eb-86d3-39cfd8a956c0.png)

And changes happenned all over our application even so in our database
![projects](https://user-images.githubusercontent.com/24781579/114743812-517b2680-9d4d-11eb-8bfd-f9463a744528.png)

We also have a beautiful project timeline chart
![projects](https://user-images.githubusercontent.com/24781579/114744104-9ef79380-9d4d-11eb-95d7-22eb5c37b10c.png)

A bright look to our postgresql database

![projects](https://user-images.githubusercontent.com/24781579/114745429-ecc0cb80-9d4e-11eb-828b-2f20e71914e2.png)













