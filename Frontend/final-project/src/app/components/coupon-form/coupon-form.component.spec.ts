import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CouponFormComponent } from './coupon-form.component';

describe('CouponFormComponent', () => {
  let component: CouponFormComponent;
  let fixture: ComponentFixture<CouponFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CouponFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CouponFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
