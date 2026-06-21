# javaCalc

- Biblioteca Java com implementações de métodos numéricos para interpolação, ajuste de curvas e integração numérica.

## Estrutura do projeto
Estrutura do Projeto
```
.
├── curveFitting
│   ├── CurveFitting.java
│   ├── LeastSquares.java
│   └── LinearFunction.java
├── integration
│   ├── gaussian
│   │   ├── Function.java
│   │   ├── Gaussian.java
│   │   ├── GaussianQuadratureGaussian.java
│   │   └── TorqueFunction.java
│   └── newtonCotes
│       ├── NewtonCotes.java
│       ├── Simpson13NewtonCotes.java
│       ├── Simpson38NewtonCotes.java
│       └── TrapezeNewtonCotes.java
├── interpolation
│   ├── GregoryNewtonInterpolation.java
│   ├── Interpolation.java
│   ├── LagrangeInterpolation.java
│   ├── NewtonInterpolation.java
│   ├── SplineCubicInterpolation.java
│   └── SplineLinearInterpolation.java
└── Library.java
```

## Algoritmos

### Interpolação
- Lagrange
- Newton
- Gregory-Newton
- Spline linear
- Spline cúbica

### Ajuste de curvas
- Métodos dos mínimos quadrados

### Integração numérica

#### Newton-Cotes
Aproximação de integrais definidas
- Regra do trapézio
- Regra de Simpson 1/3
- Regra de Simpson 3/8

#### Quadratura Gaussiana
- Integração por Quadratura de Gauss

## Tecnologias
- Java 21
- Gradle
- JUnit 5

## Pré-resquisitos
- Java 21 ou superior
- Gradle

## Como executar
### Compilação
```
./gradlew build
```
### Executar aplicação
```
./gradlew run
```
### Executar os Testes
```
./gradlew test
```

## Autores
Edson Carlos
