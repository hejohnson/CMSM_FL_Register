#!/bin/bash

 apt-get -y remove --purge libreoffice*
 apt-get clean
 apt-get -y autoremove

# apt-get -y install python-software-properties
# add-apt-repository -y ppa:webupd8team/java
# apt-get update
# apt-get install -y oracle-java8-installer

# apt-get clean
# apt-get -y autoremove
 
 apt-get -y install subversion

mkdir ~/Desktop/CashRegister
USR=$(logname)
chown $USR ~/Desktop/CashRegister
chgrp $USR ~/Desktop/CashRegister

cd ~/Desktop/CashRegister
wget https://cmsmcashregister.s3.us-east-2.amazonaws.com/RunEditor.sh
wget https://cmsmcashregister.s3.us-east-2.amazonaws.com/RunRegister.sh
wget https://cmsmcashregister.s3.us-east-2.amazonaws.com/update_editor.sh
wget https://cmsmcashregister.s3.us-east-2.amazonaws.com/update.sh
wget -r -np -R "index.html*" https://cmsmcashregister.s3.us-east-2.amazonaws.com/resources

chown $USR -R ~/Desktop/CashRegister/*
chgrp $USR -R ~/Desktop/CashRegister/*

chmod +x *.sh

/bin/bash update_editor.sh
/bin/bash update.sh

wget https://cmsmcashregister.s3.us-east-2.amazonaws.com/10periodic
sudo mv -f 10periodic /etc/apt/apt.conf.d/" > temp.sh
chmod +x temp.sh
gnome-terminal -e ./temp.sh
rm temp.sh
