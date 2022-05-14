import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Categories } from 'src/app/contracts/enums';
import { IManufacturerDto, IProductDto } from 'src/app/contracts/interfaces';
import { CommService } from 'src/app/services/comm.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss'],
})
export class DetailsComponent implements OnInit {

  productId!: number;
  product!: IProductDto;
  brand!: IManufacturerDto;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private _productService: ProductService,
    private _commService: CommService
  ) {}

  ngOnInit() {
    this.productId = this.route.snapshot.params['id'];
    
    this._productService.getProductById(this.productId).subscribe(
      (result) => {
        this.product = result;
    });
  }

  onBack() {
    this.location.back();
  }

  isCategoryGear(product: IProductDto) {
    return product.category.id == Categories.Gear
  }

  onAddToCart() {
    this._commService.deliver(this.product);
  }
}
