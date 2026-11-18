#!/bin/bash
read -p "Enter first number: " n1
read -p "Enter second number: " n2

echo ""
echo "Sum		: $((n1 + n2))"
echo "Difference	: $((n1 - n2))"
echo "Product		: $((n1 * n2))"
echo "Quotient	: $((n1 / n2))"
