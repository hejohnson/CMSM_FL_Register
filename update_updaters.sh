#!/bin/bash
gnome-terminal -e "wget --backups=1 https://github.com/hejohnson/CMSM_FL_Register/raw/master/update_editor.sh;
chmod +x update_editor.sh;
wget --backups=1 https://github.com/hejohnson/CMSM_FL_Register/raw/master/update.sh;
chmod +x update.sh"