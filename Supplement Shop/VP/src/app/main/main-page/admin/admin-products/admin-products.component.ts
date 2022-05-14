import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import * as alertify from 'alertifyjs';
import { CommService } from 'src/app/services/comm.service';
import { IProductDto } from 'src/app/contracts/interfaces';
import { take } from 'rxjs/operators';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.scss'],
})
export class AdminProductsComponent implements OnInit {
  
  flag: boolean = false;
  temp_var: boolean = false;
  data!: IProductDto[];
  count: number = 0;
  product: IProductDto | undefined;

  constructor(private _productService: ProductService) {}

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this._productService.getProducts().pipe(take(1))
      .subscribe((result: IProductDto[]) => {
        this.data = result;
        this.count = result.length;
        this.temp_var = true;
    });
  }

  toggleAdd() {
    this.product = undefined;
    this.flag = !this.flag;
  }

  toggleEdit(item: IProductDto) {
    this.product = item;
    this.flag = !this.flag;
  }

  onDelete(id: number) {
    if (confirm('Are you sure about deleting this product?')) {
      this._productService.deleteProduct(id).subscribe((res) => {
        this.getProducts();
        alertify.success('You have successfuly deleted the product!');
      });
    }
  }
}