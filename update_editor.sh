#!/bin/bash
echo "mv CashRegisterEditor_latest.jar CashRegisterEditor_old.jar;
wget https://cmsmcashregister.s3.us-east-2.amazonaws.com/CashRegisterEditor_latest.jar;
wget --backups=1 https://cmsmcashregister.s3.us-east-2.amazonaws.com/update_updaters.sh;
chmod +x update_updaters.sh" > temp.sh

chmod +x temp.sh
gnome-terminal -e ./temp.sh
rm temp.sh


