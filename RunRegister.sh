#/bin/bash

cd ~/Desktop/CashRegister
java -jar CashRegister_latest.jar > log_$(date +%Y_%m_%d__%H_%M_%S).log
