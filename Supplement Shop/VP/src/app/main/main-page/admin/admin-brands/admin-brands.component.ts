import { Component, OnInit } from '@angular/core';
import * as alertify from 'alertifyjs';
import { IManufacturerDto } from 'src/app/contracts/interfaces';
import { take } from 'rxjs/operators';
import { BrandService } from 'src/app/services/brand.service';
import { CommService } from 'src/app/services/comm.service';

@Component({
  selector: 'app-admin-brands',
  templateUrl: './admin-brands.component.html',
  styleUrls: ['./admin-brands.component.scss'],
})
export class AdminBrandsComponent implements OnInit {
  
  flag: boolean = false;
  temp_var: boolean = false;
  data!: IManufacturerDto[];
  count: number = 0;
  brand: IManufacturerDto | undefined;

  constructor(private _brandService: BrandService) {}

  ngOnInit() {
    this.getBrands();
  }

  getBrands() {
    this._brandService.getManufacturers().pipe(take(1))
      .subscribe((result: IManufacturerDto[]) => {
        this.data = result;
        this.count = result.length;
        this.temp_var = true;
    });
  }

  toggleAdd() {
    this.brand = undefined;
    this.flag = !this.flag;
  }

  toggleEdit(item: IManufacturerDto) {
    this.brand = item;
    this.flag = !this.flag;
  }

  onDelete(id: number) {
    if (confirm('Are you sure about deleting this brand?')) {
      this._brandService.deleteManufacturer(id).subscribe((res) => {
        this.getBrands();
        alertify.success('You have successfuly deleted the brand!');
      });
    }
  }
}