#!/bin/bash

source_path=test.dot
format=png

dot -T$format $source_path -o dot.$format
neato -T$format $source_path -o neato.$format

