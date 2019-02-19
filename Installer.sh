#!/bin/bash

sudo apt-get remove --purge libreoffice*
sudo apt-get clean
sudo apt-get autoremove

sudo apt-get install python-software-properties
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer

sudo apt-get clean
sudo apt-get autoremove

sudo apt-get install xubuntu-desktop
sudo apt-get remove --purge firefox
sudo apt-get remove --purge thunderbird

sudo apt-get clean
sudo apt-get autoremove

mkdir ~/Desktop/CashRegister
cd ~/Desktop/CashRegister
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/resources/
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/RunEditor.sh
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/RunRegister.sh
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/update_editor.sh
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/update.sh

chmod +x *.sh

/bin/bash update_editor.sh
/bin/bash update.sh
