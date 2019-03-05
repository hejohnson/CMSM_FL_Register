#!/bin/bash

 apt-get -y remove --purge libreoffice*
 apt-get clean
 apt-get -y autoremove

 apt-get -y install python-software-properties
 add-apt-repository -y ppa:webupd8team/java
 apt-get update
 apt-get install -y oracle-java8-installer

 apt-get clean
 apt-get -y autoremove
 
 apt-get -y install subversion

mkdir ~/Desktop/CashRegister
USR=$(logname)
chown $USR ~/Desktop/CashRegister
chgrp $USR ~/Desktop/CashRegister

cd ~/Desktop/CashRegister
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/RunEditor.sh
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/RunRegister.sh
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/update_editor.sh
wget http://github.com/hejohnson/CMSM_FL_Register/raw/master/update.sh
svn export https://github.com/hejohnson/CMSM_FL_Register.git/trunk/resources

chown $USR -R ~/Desktop/CashRegister/*
chgrp $USR -R ~/Desktop/CashRegister/*

chmod +x *.sh

/bin/bash update_editor.sh
/bin/bash update.sh
