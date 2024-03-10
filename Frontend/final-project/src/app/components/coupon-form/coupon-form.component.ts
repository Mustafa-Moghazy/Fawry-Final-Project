import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-coupon-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './coupon-form.component.html',
  styleUrl: './coupon-form.component.css',
})
export class CouponFormComponent {
  coupon = {
    code: '',
    maxUsage: null,
    valueType: '',
    value: null,
  };

  onSubmit() {
    console.log('Submitted Coupon:', this.coupon);
    this.clearForm();
  }

  clearForm() {
    this.coupon.code = '';
    this.coupon.maxUsage = null;
    this.coupon.valueType = '';
    this.coupon.value = null;
  }
}
