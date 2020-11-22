import { Component, OnInit } from '@angular/core';
import { Ingredient, unitEnum } from '../ingredient';

@Component({
  selector: 'app-storage',
  templateUrl: './storage.component.html',
  styleUrls: ['./storage.component.scss'],
})
export class StorageComponent implements OnInit {
  fridge: Ingredient[] = [
    {
      Name: 'Túró',
      Quantity: 150,
      Unit: unitEnum.dkg,
    },
    {
      Name: 'Liszt',
      Quantity: 300,
      Unit: unitEnum.dkg,
    },
  ];

  chamber: Ingredient[] = [
    {
      Name: 'Alma',
      Quantity: 150,
      Unit: unitEnum.dkg,
    },
    {
      Name: 'Liszt',
      Quantity: 300,
      Unit: unitEnum.dkg,
    },
    {
      Name: 'Olaj',
      Quantity: 1,
      Unit: unitEnum.üveg,
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
