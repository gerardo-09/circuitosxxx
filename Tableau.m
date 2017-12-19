%% Formulación Tableau

% Limpiar
clc;
close all;
clear all;

ramas = input('Número de ramas: ');
nodos = input('Número de nodos: ');

identidad1 = eye(ramas)
% for c = 1:ramas
%     tabla[c]=c
% end
ceros2 = zeros(ramas)
corrientes = input('Ingrese dirección de corrientes: '); % [-1 1 1 0; 0 0 -1 1]  Modificar
corrientesT = -corrientes'

admitancia = diag (input('Ingrese admitancias: '))
impedancia = diag (input('Ingrese impedancias: '))   %blkdiag(5,6,7,8)
ceros6 = zeros(ramas, nodos)

ceros7 = zeros(nodos, ramas)
corrientes
ceros9 = zeros(nodos)

A = [identidad1 ceros2 corrientesT; admitancia impedancia ceros6; ceros7 corrientes ceros9]

x1 = zeros(ramas,1)
x2 = input('Ingrese voltaje y/o corrientes: ') %[10; 0; 0; 0]
x3 = zeros(nodos,1) 
B = [x1; x2; x3]

% Solución de matriz
C = inv(A)*B