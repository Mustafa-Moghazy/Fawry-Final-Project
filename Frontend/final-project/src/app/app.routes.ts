import { Routes } from '@angular/router';
import { CouponFormComponent } from './components/coupon-form/coupon-form.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'create-coupon', component: CouponFormComponent },
];
