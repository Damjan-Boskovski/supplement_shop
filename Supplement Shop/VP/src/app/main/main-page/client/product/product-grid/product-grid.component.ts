import { Component, Input, OnInit } from '@angular/core';
import { IManufacturerDto, IProductDto } from 'src/app/contracts/interfaces';
import { CommService } from 'src/app/services/comm.service';

@Component({
  selector: 'app-product-grid',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-grid.component.css'],
})
export class ProductGridComponent implements OnInit {
  @Input()
  public product!: IProductDto;

  constructor(private _commService: CommService) {}

  ngOnInit() {}

  onAddToCart() {
    this._commService.deliver(this.product);
  }
}