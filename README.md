#  RefriJarvis

## Funkcionális követelmények
* Adatbázis kezelés
  * 4 tábla
    * Hűtő
    * Spájz
    * Receptek
    * Hozzávalók
* Webes felhasználói felület
* Receptjavaslatok feltöltése admini jóváhagyásra a felhasználók által

## Nem funkcionális követelmények
* Dark mode
* Egy étel mennyisége a kritikus szint alá csökken, utánna pirosan jelenik meg
* Hűtő és Spájz aktuális állapot megtekintése (read-only)

## Szerepkörök
* Admin : képes receptek feltöltésére, illetve a hűtő karbantartására
* Hűtőfelelős : képes élelmiszerek feltöltésére, így karban tartja az adatbázist
* n db felhasználó : képes keresni a rendelkezésre álló alapanyagok alapján a receptek között, és kiválaszthatja, mit szeretne elkészíteni
