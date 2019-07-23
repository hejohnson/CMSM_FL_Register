#!/bin/bash
echo "mv CashRegister_latest.jar CashRegister_old.jar;
wget https://cmsmcashregister.s3.us-east-2.amazonaws.com/CashRegister_latest.jar;
cd resources;
wget -r -np -R "index.html*" https://cmsmcashregister.s3.us-east-2.amazonaws.com/resources/core" > temp.sh

chmod +x temp.sh
gnome-terminal -e ./temp.sh
rm temp.sh
