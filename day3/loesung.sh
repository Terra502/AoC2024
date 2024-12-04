#!/usr/bin/env bash
grep -o "mul([0-9]*,[0-9]*)" input.txt | sed 's/(/ /g' | sed 's/,/ /g' | sed 's/)//g' | sed 's/mul //g' > ergebnis.txt
sum="0"
cat ergebnis.txt | while read zahl1 zahl2; do
  sum="$((sum+zahl1*zahl2))"
  echo "$sum"
done
