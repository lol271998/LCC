#!/bin/bash
echo -n "numero = ? "
read value
if (($value % 2 == 0))
then
echo "par"
else
echo "impar"
fi