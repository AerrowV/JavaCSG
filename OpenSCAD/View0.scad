union()
{
    translate([0.0, 0.0, 0.5])
    {
        linear_extrude(height = 1.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
        {
            scale([90.0, 90.0])
            {
                M8();
            }
        }
    }
    union()
    {
        translate([-46.5, 0.0, 5.0])
        {
            linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([3.0, 96.0])
                {
                    M8();
                }
            }
        }
        translate([46.5, 0.0, 5.0])
        {
            linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([3.0, 96.0])
                {
                    M8();
                }
            }
        }
        translate([0.0, 46.5, 5.0])
        {
            linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([90.0, 3.0])
                {
                    M8();
                }
            }
        }
        translate([0.0, -46.5, 5.0])
        {
            linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([90.0, 3.0])
                {
                    M8();
                }
            }
        }
    }
    union()
    {
        translate([0.0, -15.0, 3.5])
        {
            linear_extrude(height = 5.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([90.0, 0.1])
                {
                    M8();
                }
            }
        }
        translate([0.0, 15.0, 3.5])
        {
            linear_extrude(height = 5.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([90.0, 0.1])
                {
                    M8();
                }
            }
        }
        translate([-15.0, 0.0, 3.5])
        {
            linear_extrude(height = 5.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([0.1, 90.0])
                {
                    M8();
                }
            }
        }
        translate([15.0, 0.0, 3.5])
        {
            linear_extrude(height = 5.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([0.1, 90.0])
                {
                    M8();
                }
            }
        }
    }
}

module M8()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
