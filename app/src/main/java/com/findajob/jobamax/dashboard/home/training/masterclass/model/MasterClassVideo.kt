package com.findajob.jobamax.dashboard.home.training.masterclass.model

import com.findajob.jobamax.R

data class MasterClassVideo(
        val id: Int,
        val title: String,
        val description: String,
        val duration: String,
        val image: Int
){
    companion object {
        fun generateMockData(): List<MasterClassVideo>{
            return listOf(
                    MasterClassVideo(
                            id = 0,
                            title = "1. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 1,
                            title = "2. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 2,
                            title = "3. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 3,
                            title = "4. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 4,
                            title = "5. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 5,
                            title = "6. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 6,
                            title = "7. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 7,
                            title = "8. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 8,
                            title = "9. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 9,
                            title = "10. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    ),
                    MasterClassVideo(
                            id = 10,
                            title = "11. Tile Name",
                            description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus etmagnis dis parturient montes, nascetur ridiculus mus.",
                            duration = "60m",
                            image = R.drawable.img_master_class

                    )
            )

        }
    }
}