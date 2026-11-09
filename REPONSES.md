# Réponses — Évaluation POO : héritage, polymorphisme, transtypage

- Matricule :47489202619
- Nom et prénom :Top Mouhamed
- N (deux derniers chiffres du matricule) :19

> Rédigez vos justifications **avec vos propres mots**. Elles serviront de base à l'échange oral.

## Exercice 1 — A. Affichage prédit

Écrivez ci-dessous, entre les deux lignes de trois accents graves, **une ligne par ligne affichée**, dans l'ordre.
Ne modifiez pas les lignes de trois accents graves.

```text
A vehicule
F null 0
E moto 119
Moto2
vehucule
moto
C3
C2
D-vehicule
F null 0
E moto 119
true false
treu
A vehicule
B vehicule
3


```

## Exercice 1 — A. Justifications

1. Ligne qui commence par « F » :new Moto() appelle d’abord Vehicule(), qui appelle demarrer(). Comme demarrer() est redéfinie, c’est la version de Moto qui s’exécute. Mais les attributs de Moto ne sont initialisés qu’après super(), donc nom vaut null et cylindree vaut 0
2. Ligne « C3 » :v.comparer(v) a un argument de type déclaré Vehicule, donc seule comparer(Vehicule) convient. L’objet réel est une Moto, qui la redéfinit : le résultat est C3.
3. Ligne « C2 » :avec le cast (Moto) v, les deux surcharges sont possibles et le compilateur prend la plus spécifique, comparer(Moto).
4. Ligne qui commence par « D- » :categorie() est static, donc choisie d’après le type déclaré de v (Vehicule)
5. Pourquoi des lignes « A », « F », « E » apparaissent avant « true false » :l’expression o == new Moto() est évaluée avant que println n’affiche quoi que ce soit. Le constructeur de cette seconde Moto imprime donc ses lignes « A », « F » et « E » avant la ligne true false.

## Exercice 1 — B. Transtypage

Colonne « Compile ? » : `oui` ou `non`. Colonne « Exécution » : `OK`, `exception` (en précisant laquelle), ou `-` si le code ne compile pas.

| n° | Compile ? | Exécution | Justification |
|----|-----------|-----------|---------------|
| 1  |   oui    |    OK     | Une Moto est un Vehicule |
| 2  |   non    |    -      | Impossible d'assigner un Vehicule à une variable de type Moto sans cast explicite |
| 3  |   oui    |    OK     | Le cast est accepté, et l’objet réel de a est bien une Moto |
| 4  |   oui    | ClassCastException | À la compilation, un cast Object vers Moto est permis. Mais b contient un Camion, qui n’est pas une Moto |
| 5  |   oui    | ClassCastException | À la compilation, un cast Object vers Moto est permis. Mais b contient un Camion, qui n’est pas une Moto |
| 6  |   oui    | ClassCastException | Un cast Object vers String compile, mais le Camion n’est pas une String |
| 7  |   non    |    -      | b est déclaré Object, et Object n’a pas de méthode type() |
| 8  |   oui    |    OK     | Un Camion est un Vehicule, donc le cast passe. Comme Camion ne redéfinit pas type(), c’est celle de Vehicule qui s’exécute |
