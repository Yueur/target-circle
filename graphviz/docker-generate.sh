#!/bin/bash

working_dir=$(cd $(dirname $0); pwd)

source_path=$working_dir/Dockerfile
image_name="127.0.0.1:5000/ubuntu-graphviz:yueur"

sudo docker build -f $source_path . -t $image_name
sudo docker run --rm -ti -v $working_dir/files:/srv $image_name "./generate.sh"

#sudo image rm $image_name

