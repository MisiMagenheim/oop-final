### Mágikus raktár

Van egy mágikus raktár ahol a varázslók tárolhatják a tárgyaikat. A tárgyak tárolásához ebben a raktárban mágikus dobozokat használnak. A mágikus dobozok előnye a hétköznapi dobozokhoz képest, hogy csak az tud belőlük kivenni egy tárgyat aki ismeri a dobozhoz tartozó varázsigét. Hátrányuk viszont, hogy egy mágikus doboz csak egy fajta tárgyat tud tárolni. Készítsd el az alábbi leírás szerinti java code-ot!

#### Item osztály
- Helye: `items` package
- Tartalmazza a következő field-eket:
  - mágikus szint `int magicLevel`
  - arany érmében számított érték `int valueInGoldCoin`
- Minden field-hez kell legyen egy getter.
- Az összes field-nek beállíthatónak kell lennie a construktor-ral.
- Az arany érmében számított érték (`int valueInGoldCoin` field) beállításához el kell készíteni a `setValueInGoldCoin(int valueInGoldCoin)` setter-t.
- A `valueInGoldCoin` field értéke csak pozitív szám lehet. Ha bárhol olyan számot adnak át paraméterként, ahol ez a feltétel sérül akkor `IllegalArgumentException` típusú exception-t kell dobni.

##### GoldCoin osztály
- Helye: `items` package
- `valueInGoldCoin` értéke alapértelmezetten 1. A GoldCoin osztály constructor-ának ne legyen paramétere a `valueInGoldCoin`.
- A mágikus szint `magicLevel` értéke alapértelmezetten 0.

##### MagicWand osztály
- Helye: `items` package
- `valueInGoldCoin` értékének beállíthatónak kell lennie a MagicWand osztály constructor-ával.
- A mágikus szint `magicLevel` értéke alapértelmezetten 5.

#### MagicBox osztály
- Helye: gyökér package (com.codecool.magicstore mappa)
- Tartalmazza a következő fieldek-et:
  - tulajdonos `String owner`
  - varázsige `String spell`
  - tárgy `Item item`,
  - mennyi van az adott tárgyból a dobozba `int itemCount`.
- Minden field-hez kell legyen egy getter, és beállíthatóak kell lenniük a constructor-ral.
- További methodok:
  - method neve: `putItemsInBox`  
    - paramétere: `int numberOfItems`
    - működése:
      - Ellenőriznie kell, hogy a megadott paraméter pozitív-e, és ha nem akkor `IllegalArgumentException` típusú exception-t kell dobnia.
      - Ezután adja hozzá a paraméterben kapott értéket az `itemCount`-hoz.
  - method neve: `removeItems`
    - paraméterek:
      - varázsige `String spell`
      - kiszedendő tárgyak száma `int numberOfItems`
    - működése:
      - Ellenőrzi, hogy a varázsige megfelelő-e (egyezik e a doboz varázsigéjével),
      - és a dobozban van-e megfelelő mennyiségű tárgy (`itemCount` nagyobb vagy egyenlő `numberOfItems`).
      - Amennyiben minden feltétel teljesül kivonja a kiszedendő tárgyak számát (`numberOfItems`) a dobozban lévő tárgyak számából (`itemCount`) és visszatér  a kiszedendő tárgyak számával (`numberOfItems`).
      - Ha valamelyik feltétel nem teljesül akkor nem módosítja a dobozban lévő tárgyak számát és 0-val tér vissza.
  - method neve: `int getItemsValueInBox()`
    - feladata: A dobozban lévő tárgyak értékének összegét adja meg arany érmében számítva.

#### MagicStore osztály
- Helye: gyökér package (com.codecool.magicstore mappa)
- Tartalmaz egy listát amelyben mágikus dobozok (`MagicBox`-ok) kerülhetnek.
- method-ok:
  - method neve: `addMagicBox`
    - paraméter: egy `MagicBox` típusú paraméter
    - működése:  Hozzáadja a paraméterben kapott mágikus dobozt a listához.
  - method neve: `getValueOfAllItemsInStore`
    - feladata: Adja vissza a raktárban lévő összes tárgy együttes értékét arany érmében kifejezve.
