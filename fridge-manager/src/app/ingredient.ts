export interface Ingredient {
    Name: String;
    Quantity: Number;
    Unit?: unitEnum;
}

export enum unitEnum{
    db = "db",
    liter = "liter",
    dkg = "dkg",
    üveg = "üveg",
}

