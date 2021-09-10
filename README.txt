---------------------------
--How to run dockerfile----
---------------------------

1) Build docker file with name Dockerfile. ( to install sqlite if not exist) using command < docker build -t jumia-api . >
2) Replace content of Dockerfile with Dockerfile2ForRun.txt then build Dockerfile again using command < docker build -t jumia-api . >
3) Run image using command < docker run -p 7080:7080 jumia-api >

-----------
--CAUTION--
-----------
** Don't forget to run CMD as an administrator **


-------------------
--Sample Request---
-------------------
http://localhost:7080/customer