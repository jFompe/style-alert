<template>
    <div class="vue-tempalte">
        <form>
            <h3>Sign Up</h3>

            <div class="form-group">
                <label>Username</label>
                <input type="text" class="form-control form-control-lg"/>
            </div>

            <div class="form-group">
                <label>Email address</label>
                <input type="email" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control form-control-lg" />
            </div>
            <div class="col text-center">
                <button type="submit" class="btn btn-primary btn-lg btn-block">Sign Up</button>
            </div>

            <p class="forgot-password text-right">
                 
                <!-- <router-link :to="name 'login'">sign in?</router-link> -->
                <router-link to="/log/login">Already registered ?</router-link>
            </p>
        </form>
    </div>
</template>

// <script>
//     export default 
//         data() 
//             return 
        
    
// </script>