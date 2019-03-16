#!/bin/bash
echo -e "mv CashRegisterEditor_latest.jar CashRegisterEditor_old.jar;
wget https://github.com/hejohnson/CMSM_FL_Register/raw/master/binaries/CashRegisterEditor_latest.jar;
wget https://github.com/hejohnson/CMSM_FL_Regiser/raw/master/update_updaters.sh;
chmod +x update_updaters.sh" > temp.sh
chmod +x temp.sh
gnome-terminal -e temp.sh
rm temp.sh

