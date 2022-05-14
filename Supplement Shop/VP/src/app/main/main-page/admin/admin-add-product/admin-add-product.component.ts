import { Component, Input, OnInit } from '@angular/core';
import { ICategoryDto, IManufacturerDto, IProductDto, ISaveProductDto } from 'src/app/contracts/interfaces';
import { ProductService } from 'src/app/services/product.service';
import { take } from 'rxjs/operators';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BrandService } from 'src/app/services/brand.service';
import { CategoryService } from 'src/app/services/category.service';
import { CommService } from 'src/app/services/comm.service';

@Component({
  selector: 'app-admin-add-product',
  templateUrl: './admin-add-product.component.html',
  styleUrls: ['./admin-add-product.component.scss'],
})
export class AdminAddProductComponent implements OnInit {

  public categories!: ICategoryDto[];
  public brands!: IManufacturerDto[];
  public productForm: FormGroup;
  
  @Input()
  public product: IProductDto | undefined;

  constructor(private _productService: ProductService,
              private _brandService: BrandService,
              private _categoryService: CategoryService,
              private _fb: FormBuilder) 
  {
    
    this.productForm = this._fb.group({
      name: ['', Validators.required],
      price: ['', Validators.required],
      category: [''],
      manufacturer: [''],
      imageUrl: ['', Validators.required],
      quantity: ['', Validators.required],
      description: [''] 
    })
  }

  ngOnInit() {
    this.onClear();
    this.getCategories();
    this.getBrands();
    this.setProduct();
  }

  onSubmit(form: FormGroup) {
    if (form.valid) {
      if (this.product) {
        this._productService.updateProduct(this.product.id, this.mapProduct(form)).subscribe();
      }
      else {
        this._productService.createProduct(this.mapProduct(form)).subscribe();
      }
      window.location.reload();
    }
  }

  onClear() {
    this.productForm.reset();
  }
  
  setProduct() {
    if (this.product) {
      this.productForm.controls['name'].patchValue(this.product.name);
      this.productForm.controls['price'].patchValue(this.product.price);
      this.productForm.controls['category'].patchValue(this.product.category.id);
      this.productForm.controls['manufacturer'].patchValue(this.product.manufacturer.id);
      this.productForm.controls['imageUrl'].patchValue(this.product.imageUrl);
      this.productForm.controls['quantity'].patchValue(this.product.quantity);
      this.productForm.controls['description'].patchValue(this.product.description);
    }
  }

  mapProduct(form: FormGroup): ISaveProductDto {
    return {
      name: form.controls['name'].value,
      price: form.controls['price'].value,
      quantity: form.controls['quantity'].value,
      categoryId: form.controls['category'].value,
      manufacturerId: form.controls['manufacturer'].value,
      description: form.controls['description'].value,
      imageUrl: form.controls['imageUrl'].value
    };
  }

  getCategories() {
    this._categoryService.getCategories().pipe(take(1))
      .subscribe((items) => this.categories = items);
  }
  
  getBrands() {
    this._brandService.getManufacturers().pipe(take(1))
      .subscribe((items) => this.brands = items);
  }
}