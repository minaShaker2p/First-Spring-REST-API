CREATE TABLE customer (
 customerId UUID NOT NULL PRIMARY KEY,
 customerName VARCHAR(150) NOT NULL,
 invoiceId UUID
);