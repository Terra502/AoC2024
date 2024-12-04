#!/usr/bin/env bash
tr -d '\n' < input.txt | sed 's/don/\ndon/g' | sed 's_do(_\ndo(_g' | grep -v ^don | grep -o "mul([0-9]*,[0-9]*)" | sed 's/(/ /g' | sed 's/,/ /g' | sed 's/)//g' | sed 's/mul //g' > ergebnis.txt
sum="0"
cat ergebnis.txt | while read zahl1 zahl2; do
  sum="$((sum+zahl1*zahl2))"
  echo "$sum"
done
