# buynow
A second hand product sales system has been developed with hexagonal architecture.


# Address Domain

The address domain was created to meet the address needs of other components in the system.

Countries, regions and cities are kept on redis. This data is taken from the [Country State City API](https://countrystatecity.in).

System saves a total of 309663 country, region and city data to redis within 10 minutes and 49 seconds. In other words, the system records 492 data per second.

Also, you can see the db structure of address domain -> [Link](https://www.linkpicture.com/q/db-schema-for-address-domain-2.jpg) 

# Product Domain

Product domain will implement as soon as time.

You can see the db structure of product domain -> [Link](https://www.linkpicture.com/q/db-design-for-product-domain.jpg)