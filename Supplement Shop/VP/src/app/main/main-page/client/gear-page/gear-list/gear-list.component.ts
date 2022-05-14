import { Component, OnInit } from '@angular/core';
import { IProductDto } from 'src/app/contracts/interfaces';
import { ProductService } from 'src/app/services/product.service';
import { map, mergeMap, take } from 'rxjs/operators';
import { Categories } from 'src/app/contracts/enums';
@Component({
  selector: 'app-gear-list',
  templateUrl: './gear-list.component.html',
  styleUrls: ['./gear-list.component.scss'],
})
export class GearListComponent implements OnInit {
  public products!: IProductDto[];

  public name: string = '';
  public brand: string = '';
  public sortBy: string = '';
  public min: number = 0;
  public max: number = 10000;
  public currentPage: number = 1;

  constructor(private readonly _productService: ProductService) {}

  ngOnInit() {
    this.getProducts();
  }

  onNameClear() {
    this.name = '';
  }

  onBrandClear() {
    this.brand = '';
  }

  onPricesReset() {
    this.min = 0;
    this.max = 10000;
  }

  getProducts() {
    this._productService.getProducts().subscribe((items) => {
      this.products = this.filterItems(items)
    });
  }

  filterItems(items: IProductDto[]): IProductDto[]{
    return items.filter((item) => item.category.id == Categories.Gear);
  }
}
