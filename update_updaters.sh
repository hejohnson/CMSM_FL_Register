#!/bin/bash
echo "wget --backups=1 https://github.com/hejohnson/CMSM_FL_Register/raw/master/update_editor.sh;
chmod +x update_editor.sh;
wget --backups=1 https://github.com/hejohnson/CMSM_FL_Register/raw/master/update.sh;
chmod +x update.sh" > temp.sh
chmod +x temp.sh
gnome-terminal -e ./temp.sh
rm temp.sh