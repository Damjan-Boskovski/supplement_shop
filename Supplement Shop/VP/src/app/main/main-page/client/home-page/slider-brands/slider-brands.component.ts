import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-slider-brands',
  templateUrl: './slider-brands.component.html',
  styleUrls: ['./slider-brands.component.scss']
})
export class SliderBrandsComponent implements OnInit {

  constructor() { }

  imageObject: Array<object> = [
  {
    image: 'assets/images/br-2.jpg',
    thumbImage: 'assets/images/br-2.jpg'
  },
  {
    image: 'assets/images/br-4.png', // Support base64 image
    thumbImage: 'assets/images/br-4.png'
  },
  {
    image: 'assets/images/br-6.png', // Support base64 image
    thumbImage: 'assets/images/br-6.png'
  },
  {
    image: 'assets/images/br-8.jpg', // Support base64 image
    thumbImage: 'assets/images/br-8.jpg'
  },
  {
    image: 'assets/images/br-10.png', // Support base64 image
    thumbImage: 'assets/images/br-10.png'
  },
  {
    image: 'assets/images/br-2.jpg', // Support base64 image
    thumbImage: 'assets/images/br-2.jpg'
  },
  {
    image: 'assets/images/br-1.jpg',
    thumbImage: 'assets/images/br-1.jpg'
  },
  {
    image: 'assets/images/br-5.png', // Support base64 image
    thumbImage: 'assets/images/br-5.png'
  },
  {
    image: 'assets/images/br-7.png', // Support base64 image
    thumbImage: 'assets/images/br-7.png'
  },
  {
    image: 'assets/images/br-9.jpg', // Support base64 image
    thumbImage: 'assets/images/br-9.jpg'
  }
  ];

  ngOnInit() {
  }

}
