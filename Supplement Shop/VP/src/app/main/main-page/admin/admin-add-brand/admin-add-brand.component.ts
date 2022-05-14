import { Component, Input, OnInit } from '@angular/core';
import { IManufacturerDto, ISaveManufacturerDto } from 'src/app/contracts/interfaces';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BrandService } from 'src/app/services/brand.service';
import { CommService } from 'src/app/services/comm.service';

@Component({
  selector: 'app-admin-add-brand',
  templateUrl: './admin-add-brand.component.html',
  styleUrls: ['./admin-add-brand.component.scss'],
})
export class AdminAddBrandComponent implements OnInit {

  public brandForm: FormGroup;
  
  @Input()
  public brand: IManufacturerDto | undefined;

  constructor(private _brandService: BrandService,
              private _fb: FormBuilder) 
  {
    
    this.brandForm = this._fb.group({
      name: ['', Validators.required],
      country: ['', Validators.required]
    })
  }

  ngOnInit() {
    this.onClear();
    this.setBrand();
  }

  onSubmit(form: FormGroup) {
    if (form.valid) {
      if (this.brand) {
        this._brandService.updateManufacturer(this.brand.id, this.mapBrand(form)).subscribe();
      }
      else {
        this._brandService.createManufacturer(this.mapBrand(form)).subscribe();
      }
      window.location.reload();
    }
  }

  onClear() {
    this.brandForm.reset();
  }
  
  setBrand() { 
    if (this.brand) {
      this.brandForm.controls['name'].patchValue(this.brand.name);
      this.brandForm.controls['country'].patchValue(this.brand.country);
    }
  }

  mapBrand(form: FormGroup): ISaveManufacturerDto {
    return {
      name: form.controls['name'].value,
      country: form.controls['country'].value
    };
  }
}