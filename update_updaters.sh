#!/bin/bash
echo "wget --backups=1 https://cmsmcashregister.s3.us-east-2.amazonaws.com/update_editor.sh;
chmod +x update_editor.sh;
wget --backups=1 https://cmsmcashregister.s3.us-east-2.amazonaws.com/update.sh;
chmod +x update.sh" > temp.sh

chmod +x temp.sh
gnome-terminal -e ./temp.sh
rm temp.sh