#  RefriJarvis

## Relációs diagramm az adatbázis táblázataihoz:
[![database.png](https://i.postimg.cc/zfWsF1Vy/database.png)](https://postimg.cc/nsFSngKx)

## Az adatbázis elemei:
* Recipe tábla, ami tartalmazza a feltöltött receptek nevét, elkészítési módját (description) valamint a szükséges összetevőket(ingredients)
*Ingredients tábla, amire a Recipe és Fridge entity is hivatkozik, elemeinek neve és mennyisége van
*Fridge tábla, ami Ingredient elemeket tartalmaz, minden bejegyzés egy kis reckesz a "virtuális" hűtőnkben
*User tábla ami nem csak a bejelentkezéshez kell, de kapcsolatban áll a recepttekkel is
*UserHistory amiben napokra lebontva receptek lesznek elérhetőek
*Foodgroup tábla, ami három csoportra bontja az ételeket Reggeli, Ebéd és Vacsora (breakfast, lunch, dinner) enumok szerint

## Végpontok
*/recipe végpont alatt elérhetőek lesznek a receptek, összetevőikkel együtt, amiket külön le is tudunk kérdezni /recipe/{id}/ segítségével.
*Userként lehetséges feltölteni a /recipe végponton keresztül a Recipe táblát receptekkel
*Adminként lehetséges a törlés minden táblából, illetve módosítás is csak adminként lehetséges
*/fridge végpont alatt le lehet kérdezni a jelenleg rendelkezésre álló alapanyagokat
