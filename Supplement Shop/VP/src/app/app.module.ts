import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { NgImageSliderModule } from 'ng-image-slider';
import { FilterPipe } from './pipes/filter.pipe';
import { SortPipe } from './pipes/sort.pipe';
import { RangePipe } from './pipes/range.pipe';
import { NgxPaginationModule } from 'ngx-pagination';
import { AdminDashboardComponent } from './main/main-page/admin/admin-dashboard/admin-dashboard.component';
import { AdminPageComponent } from './main/main-page/admin/admin-page/admin-page.component';
import { CommonModule } from '@angular/common';
import { AdminProductsComponent } from './main/main-page/admin/admin-products/admin-products.component';
import { AdminAddProductComponent } from './main/main-page/admin/admin-add-product/admin-add-product.component';
import { NavBarComponent } from './main/nav/nav-bar/nav-bar.component';
import { NavFooterComponent } from './main/nav/nav-footer/nav-footer.component';
import { ContactComponent } from './main/main-page/client/contact-page/contact/contact.component';
import { GearBannerComponent } from './main/main-page/client/gear-page/gear-banner/gear-banner.component';
import { GearListComponent } from './main/main-page/client/gear-page/gear-list/gear-list.component';
import { GearComponent } from './main/main-page/client/gear-page/gear/gear.component';
import { BannerComponent } from './main/main-page/client/home-page/banner/banner.component';
import { CarouselComponent } from './main/main-page/client/home-page/carousel/carousel.component';
import { HomeComponent } from './main/main-page/client/home-page/home/home.component';
import { MainMenuComponent } from './main/main-page/client/home-page/main-menu/main-menu.component';
import { SliderBrandsComponent } from './main/main-page/client/home-page/slider-brands/slider-brands.component';
import { TopbestComponent } from './main/main-page/client/home-page/topbest/topbest.component';
import { TopsaleComponent } from './main/main-page/client/home-page/topsale/topsale.component';
import { SupplementsBannerComponent } from './main/main-page/client/supplements-page/supplements-banner/supplements-banner.component';
import { SupplementsListComponent } from './main/main-page/client/supplements-page/supplements-list/supplements-list.component';
import { SupplementsComponent } from './main/main-page/client/supplements-page/supplements/supplements.component';
import { DetailsComponent } from './main/main-page/client/product/details/details.component';
import { ProductGridComponent } from './main/main-page/client/product/product-grid/product-grid.component';
import { AdminBrandsComponent } from './main/main-page/admin/admin-brands/admin-brands.component';
import { AdminAddBrandComponent } from './main/main-page/admin/admin-add-brand/admin-add-brand.component';

const appRoutes = [
  { path: '', component: HomeComponent },
  { path: 'supplements', component: SupplementsComponent },
  { path: 'gear', component: GearComponent },
  { path: 'contact-us', component: ContactComponent },
  { path: 'details/:id', component: DetailsComponent },
  {
    path: 'admin',
    component: AdminPageComponent,
    children: [
      { path: '', component: AdminDashboardComponent },
      { path: 'dashboard', component: AdminDashboardComponent },
      { path: 'products', component: AdminProductsComponent },
      { path: 'brands', component: AdminBrandsComponent}
    ],
  },
  { path: '**', component: HomeComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    CarouselComponent,
    BannerComponent,
    MainMenuComponent,
    TopsaleComponent,
    TopbestComponent,
    ProductGridComponent,
    SliderBrandsComponent,
    NavFooterComponent,
    SupplementsComponent,
    SupplementsBannerComponent,
    SupplementsListComponent,
    FilterPipe,
    SortPipe,
    RangePipe,
    GearComponent,
    GearBannerComponent,
    GearListComponent,
    ContactComponent,
    DetailsComponent,
    AdminDashboardComponent,
    AdminPageComponent,
    AdminProductsComponent,
    AdminAddProductComponent,
    AdminBrandsComponent,
    AdminAddBrandComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    NgImageSliderModule,
    NgxPaginationModule,
    CommonModule,
  ],

  exports: [FormsModule, ReactiveFormsModule, HttpClientModule],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
