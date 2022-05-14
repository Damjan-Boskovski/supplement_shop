import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { IProductDto } from 'src/app/contracts/interfaces';

@Component({
  selector: 'app-topsale',
  templateUrl: './topsale.component.html',
  styleUrls: ['./topsale.component.scss'],
})
export class TopsaleComponent implements OnInit {
  products!: Array<IProductDto>;

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getProducts().subscribe((res) => {
      this.products = res.slice(0, 6);
    });
  }
}
