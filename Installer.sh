#!/bin/bash

 apt-get remove --purge libreoffice*
 apt-get clean
 apt-get autoremove

 apt-get install python-software-properties
 add-apt-repository ppa:webupd8team/java
 apt-get update
 apt-get install oracle-java8-installer

 apt-get clean
 apt-get autoremove

 apt-get install xubuntu-desktop
 apt-get remove --purge firefox
 apt-get remove --purge thunderbird

 apt-get clean
 apt-get autoremove

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
