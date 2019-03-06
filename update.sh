#!/bin/bash
mv CashRegister_latest.jar CashRegister_old.jar
wget https://github.com/hejohnson/CMSM_FL_Register/raw/master/binaries/CashRegister_latest.jar
cd resources
svn export --force https://github.com/hejohnson/CMSM_FL_Register.git/trunk/resources/core
